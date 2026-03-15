from sqlalchemy import Column, Integer, String, DateTime
from sqlalchemy.sql import func
from database import Base

class User(Base):
    __tablename__ = "users"

    id = Column(Integer, primary_key=True)
    username = Column(String(50), nullable=False)
    email = Column(String(100), nullable=False, unique=True)
    password_hash = Column(String(255), nullable=False)
    created_at = Column(DateTime, server_default=func.now(), nullable=False)