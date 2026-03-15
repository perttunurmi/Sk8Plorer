from sqlalchemy import Column, Integer, String, DateTime
from sqlalchemy.sql import func
from database import Base

class Trick(Base):
    __tablename__ = "tricks"

    id = Column(Integer, primary_key=True)
    name = Column(String(100), nullable=False, unique=True)
    category = Column(String(100))