from sqlalchemy import Column, Integer, String, DateTime
from sqlalchemy.sql import func
from database import Base

class Spot_Trick(Base):
    __tablename__ = "spot_tricks"

    id = Column(Integer, primary_key=True)
    spot_id = Column(Integer, nullable=False)
    trick_id = Column(Integer, nullable=False)
    user_id = Column(Integer, nullable=False)
    video_url = Column(String)
    created_at = Column(DateTime, server_default=func.now(), nullable=False)
