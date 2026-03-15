from sqlalchemy import Column, Integer, String, DateTime, Enum
from sqlalchemy.sql import func
from database import Base
from geoalchemy2 import Geography
import enum

class SpotCategory(enum.Enum):
    street = "street"
    park = "park"

class Spot(Base):
    __tablename__ = "spots"

    id = Column(Integer, primary_key=True)
    name = Column(String(150), nullable=False, unique=True)
    city = Column(String(150))
    country = Column(String(150))
    spot_type = Column(Enum(SpotCategory, name="spot_type_enum", create_type=False), nullable=False)
    location = Column(Geography(geometry_type='POINT', srid=4326), nullable=False)
    created_at = Column(DateTime, server_default=func.now(), nullable=False)
    image_url = Column(String)